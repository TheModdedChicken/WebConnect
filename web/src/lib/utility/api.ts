/**
 * Wrapper for `fetch` to include error handling
 */
async function api(input: RequestInfo | URL, init?: RequestInit) {
  const res = await fetch(input, init);

  // try-catch in case JSON parsing fails
  try {
    const data = await res.json();

    if (res.ok) return data;
    else throw new APIError(res.status, data.message) // Throw verbose API error
  } catch (e) {
    throw new APIError(res.status) // Throw unknown API error
  }
}

interface IBranding {
  title?: string
  subtitle?: string
}

async function getBranding(): Promise<IBranding | never> {
  return (await api('/api/branding')) as IBranding;
}